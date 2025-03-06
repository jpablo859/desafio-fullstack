import React from 'react';
import { useUserContext } from '../context/UserContext';

export const UserHeader: React.FC = () => {
    const { showForm, handleNewUser } = useUserContext();

    return (
        <div className="row mb-4">
            <div className="col-md-8">
                <h1 className="display-4">Administración de Usuarios</h1>
            </div>
            <div className="col-md-4 text-end">
                {!showForm && (
                    <button 
                        className="btn btn-primary mt-3"
                        onClick={() => handleNewUser()}
                    >
                        Crear Nuevo Usuario
                    </button>
                )}
            </div>
        </div>
    );
}; 