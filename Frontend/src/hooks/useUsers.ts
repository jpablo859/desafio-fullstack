import { useState, useCallback } from 'react';
import { userService } from '../services/userService';
import { alertService } from '../services/alertService';
import { User } from '../types/user';
import { useUserContext } from '../context/UserContext';

export const useUsers = () => {
    const [users, setUsers] = useState<User[]>([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState<string | null>(null);
    const { triggerRefresh } = useUserContext();

    const loadUsers = useCallback(async () => {
        try {
            setLoading(true);
            const response = await userService.getUsers();
            setUsers(response.data);
        } catch (err) {
            setError('Error al cargar usuarios');
            await alertService.error('Error al cargar la lista de usuarios');
        } finally {
            setLoading(false);
        }
    }, []);

    const deleteUser = useCallback(async (id: number) => {
        const result = await alertService.confirm('Esta acción no se puede deshacer');

        if (result.isConfirmed) {
            try {
                setLoading(true);
                const { message } = await userService.deleteUser(id);
                triggerRefresh(); // Actualizamos la lista después de eliminar
                await alertService.success(message);
            } catch (err) {
                await alertService.error('Error al eliminar el usuario');
            } finally {
                setLoading(false);
            }
        }
    }, [triggerRefresh]);

    return {
        users,
        loading,
        error,
        loadUsers,
        deleteUser
    };
}; 