import React from 'react';

interface FormActionsProps {
    isEditing: boolean;
    onCancel: () => void;
    isSubmitting: boolean;
}

export const FormActions: React.FC<FormActionsProps> = ({
    isEditing,
    onCancel,
    isSubmitting
}) => {
    return (
        <div className="d-grid gap-2">
            <button 
                type="submit" 
                className="btn btn-primary"
                disabled={isSubmitting}
            >
                {isSubmitting ? (
                    <>
                        <span className="spinner-border spinner-border-sm me-2" role="status" aria-hidden="true"></span>
                        Guardando...
                    </>
                ) : (
                    `${isEditing ? 'Actualizar' : 'Crear'} Usuario`
                )}
            </button>
            <button 
                type="button" 
                className="btn btn-secondary"
                onClick={onCancel}
                disabled={isSubmitting}
            >
                Cancelar
            </button>
        </div>
    );
}; 