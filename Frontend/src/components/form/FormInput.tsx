import React from 'react';

interface FormInputProps {
    label: string;
    name: string;
    type?: string;
    value: string;
    onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
    required?: boolean;
    placeholder?: string;
}

export const FormInput: React.FC<FormInputProps> = ({
    label,
    name,
    type = 'text',
    value,
    onChange,
    required = false,
    placeholder
}) => {
    return (
        <div className="mb-3">
            <label htmlFor={name} className="form-label">{label}:</label>
            <input
                type={type}
                className="form-control"
                id={name}
                name={name}
                value={value}
                onChange={onChange}
                required={required}
                placeholder={placeholder}
            />
        </div>
    );
}; 