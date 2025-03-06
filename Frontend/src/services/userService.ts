import axios from 'axios';
import { User, UserFormData } from '../types/user';
import { ApiResponse } from '../types/apiResponse';

const API_URL = import.meta.env.VITE_API_URL;

export const userService = {
    getUsers: async (): Promise<ApiResponse<User[]>> => {
        const response = await axios.get(`${API_URL}/all`);
        return response.data;
    },

    getUserById: async (id: string): Promise<ApiResponse<User>> => {
        const response = await axios.get(`${API_URL}/by-id/${id}`);
        return response.data;
    },

    createUser: async (userData: UserFormData): Promise<ApiResponse<User>> => {
        const response = await axios.post(`${API_URL}/create`, userData);
        return response.data;
    },

    updateUser: async (id: string, userData: UserFormData): Promise<ApiResponse<User>> => {
        const response = await axios.put(`${API_URL}/update`, userData);
        return response.data;
    },

    deleteUser: async (id: number): Promise<ApiResponse<void>> => {
        const response = await axios.delete(`${API_URL}/delete/${id}`);
        return response.data;
    }
}; 