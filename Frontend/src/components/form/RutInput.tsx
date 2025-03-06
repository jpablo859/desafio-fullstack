import React from 'react';

interface RutInputProps {
    rutValue: string;
    dvValue: string;
    onChange: (e: React.ChangeEvent<HTMLInputElement>) => void;
}

export const RutInput: React.FC<RutInputProps> = ({
    rutValue,
    dvValue,
    onChange
}) => {
    return (
        <div className="mb-3">
            <label htmlFor="rut" className="form-label">RUT:</label>
            <div className="input-group">
                <input
                    type="text"
                    className="form-control"
                    id="rut"
                    name="rut"
                    value={rutValue}
                    onChange={onChange}
                    placeholder="12345678"
                    style={{ width: '60%' }}
                    required
                />
                <span className="input-group-text">-</span>
                <input
                    type="text"
                    className="form-control"
                    style={{ width: '20%' }}
                    id="dv"
                    name="dv"
                    value={dvValue}
                    onChange={onChange}
                    placeholder="K"
                    required
                />
            </div>
        </div>
    );
}; 