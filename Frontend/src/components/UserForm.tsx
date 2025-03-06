import React, { useReducer, useEffect } from 'react';
import { userService } from '../services/userService';
import { useUserContext } from '../context/UserContext';
import { alertService } from '../services/alertService';
import { FormInput } from './form/FormInput';
import { RutInput } from './form/RutInput';
import { FormActions } from './form/FormActions';
import { 
    userFormReducer, 
    initialState 
} from '../reducers/userFormReducer';

export const UserForm: React.FC = () => {
    const { showForm, selectedUserId, handleFormSuccess } = useUserContext();
    const [state, dispatch] = useReducer(userFormReducer, initialState);

    useEffect(() => {
        const loadUserData = async () => {
            if (selectedUserId) {
                try {
                    dispatch({ type: 'SET_LOADING', payload: true });
                    const { data } = await userService.getUserById(selectedUserId);
                    dispatch({ type: 'SET_FORM_DATA', payload: data });
                } catch (error) {
                    dispatch({ type: 'SET_ERROR', payload: 'Error al cargar los datos del usuario' });
                    await alertService.error('Error al cargar los datos del usuario');
                    handleFormSuccess();
                } finally {
                    dispatch({ type: 'SET_LOADING', payload: false });
                }
            } else {
                dispatch({ type: 'RESET_FORM' });
            }
        };

        loadUserData();
    }, [selectedUserId]);

    if (!showForm) return null;

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            dispatch({ type: 'SET_LOADING', payload: true });
            if (selectedUserId) {
                await userService.updateUser(selectedUserId, state.formData);
                await alertService.success('Usuario actualizado correctamente');
            } else {
                await userService.createUser(state.formData);
                await alertService.success('Usuario creado correctamente');
            }
            handleFormSuccess();
        } catch (error) {
            dispatch({ type: 'SET_ERROR', payload: 'Error al guardar el usuario' });
            await alertService.error('Error al guardar el usuario');
        } finally {
            dispatch({ type: 'SET_LOADING', payload: false });
        }
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        dispatch({ 
            type: 'UPDATE_FIELD', 
            payload: { name, value } 
        });
    };

    if (state.isLoading) {
        return <div className="text-center">Cargando...</div>;
    }

    return (
        <div className="row mb-4 justify-content-center">
            <div className="col-md-8">
                <div className="card shadow-lg p-3 mb-5 bg-body">
                    <div className="card-body">
                        <h5 className="card-title text-center">
                            {selectedUserId ? 'Editar' : 'Crear'} Usuario
                        </h5>
                        {state.error && (
                            <div className="alert alert-danger">{state.error}</div>
                        )}
                        <form onSubmit={handleSubmit} className="text-center">
                            <div className="row mb-3">
                                <div className="col-md-6">
                                    <FormInput
                                        label="Nombres"
                                        name="nombres"
                                        value={state.formData.nombres}
                                        onChange={handleChange}
                                        required
                                    />
                                </div>
                                <div className="col-md-6">
                                    <FormInput
                                        label="Apellidos"
                                        name="apellidos"
                                        value={state.formData.apellidos}
                                        onChange={handleChange}
                                        required
                                    />
                                </div>
                            </div>

                            <div className="row mb-3">
                                <div className="col-md-6">
                                    <RutInput
                                        rutValue={state.formData.rut}
                                        dvValue={state.formData.dv}
                                        onChange={handleChange}
                                    />
                                </div>
                                <div className="col-md-6">
                                    <FormInput
                                        label="Fecha de Nacimiento"
                                        name="fechaNacimiento"
                                        type="date"
                                        value={state.formData.fechaNacimiento}
                                        onChange={handleChange}
                                        required
                                    />
                                </div>
                            </div>

                            <FormInput
                                label="Correo Electrónico"
                                name="correoElectronico"
                                type="email"
                                value={state.formData.correoElectronico}
                                onChange={handleChange}
                                required
                            />

                            <FormInput
                                label="Contraseña"
                                name="contrasena"
                                type="password"
                                value={state.formData.contrasena}
                                onChange={handleChange}
                            />

                            <FormActions
                                isEditing={!!selectedUserId}
                                onCancel={handleFormSuccess}
                                isSubmitting={state.isLoading}
                            />
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}; 