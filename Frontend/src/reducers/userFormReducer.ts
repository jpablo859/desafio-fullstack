import { UserFormData } from '../types/user';

export type UserFormState = {
    formData: UserFormData;
    isLoading: boolean;
    error: string | null;
};

export type UserFormAction =
    | { type: 'SET_FORM_DATA'; payload: UserFormData }
    | { type: 'UPDATE_FIELD'; payload: { name: string; value: string } }
    | { type: 'RESET_FORM' }
    | { type: 'SET_LOADING'; payload: boolean }
    | { type: 'SET_ERROR'; payload: string | null };

export const initialState: UserFormState = {
    formData: {
        nombres: '',
        apellidos: '',
        rut: '',
        dv: '',
        fechaNacimiento: '',
        correoElectronico: '',
        contrasena: ''
    },
    isLoading: false,
    error: null
};

export const userFormReducer = (state: UserFormState, action: UserFormAction): UserFormState => {
    switch (action.type) {
        case 'SET_FORM_DATA':
            return {
                ...state,
                formData: action.payload,
                error: null
            };
        case 'UPDATE_FIELD': {
            const { name, value } = action.payload;
            let finalValue = value;

            if (name === 'dv') {
                finalValue = value.toUpperCase().replace(/[^0-9K]/g, '').slice(0, 1);
            } else if (name === 'rut') {
                finalValue = value.replace(/\D/g, '').slice(0, 8);
            }

            return {
                ...state,
                formData: {
                    ...state.formData,
                    [name]: finalValue
                }
            };
        }
        case 'RESET_FORM':
            return {
                ...initialState
            };
        case 'SET_LOADING':
            return {
                ...state,
                isLoading: action.payload
            };
        case 'SET_ERROR':
            return {
                ...state,
                error: action.payload
            };
        default:
            return state;
    }
}; 