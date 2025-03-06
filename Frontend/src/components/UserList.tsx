import React, { useEffect } from 'react';
import { useUsers } from '../hooks/useUsers';
import { useUserContext } from '../context/UserContext';

export const UserList: React.FC = () => {
    const { showForm, setShowForm, setSelectedUserId, refreshList } = useUserContext();
    const { users, loading, error, loadUsers, deleteUser } = useUsers();

    useEffect(() => {
        loadUsers();
    }, [loadUsers, refreshList]);

    const handleEdit = (id: number) => {
        setSelectedUserId(id.toString());
        setShowForm(true);
    };

    if (showForm) return null;
    if (loading) return <div>Cargando...</div>;
    if (error) return <div className="alert alert-danger">{error}</div>;

    return (
        <div className="row">
            <div className="col">
                <div className="card">
                    <div className="card-body">
                        <h2 className="card-title">Lista de Usuarios</h2>
                        <div className="table-responsive">
                            <table className="table table-hover">
                                <thead className="table-light">
                                    <tr>
                                        <th>Nombres</th>
                                        <th>Apellidos</th>
                                        <th>RUT</th>
                                        <th>Fecha Nacimiento</th>
                                        <th>Correo Electrónico</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {users.map((user) => (
                                        <tr key={user.id}>
                                            <td>{user.nombres}</td>
                                            <td>{user.apellidos}</td>
                                            <td>{user.rut}-{user.dv}</td>
                                            <td>{new Date(user.fechaNacimiento).toLocaleDateString()}</td>
                                            <td>{user.correoElectronico}</td>
                                            <td>
                                                <div className="btn-group" role="group">
                                                    <button 
                                                        className="btn btn-sm btn-danger"
                                                        onClick={() => deleteUser(user.id)}
                                                    >
                                                        <i className="bi bi-trash"></i> Eliminar
                                                    </button>
                                                    <button 
                                                        className="btn btn-sm btn-primary ms-2"
                                                        onClick={() => handleEdit(user.id)}
                                                    >
                                                        <i className="bi bi-pencil"></i> Editar
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    ))}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}; 