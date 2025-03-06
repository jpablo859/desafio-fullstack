import React, { createContext, useContext, ReactNode } from 'react';

interface UserContextType {
    showForm: boolean;
    selectedUserId?: string;
    refreshList: boolean;
    setShowForm: (show: boolean) => void;
    setSelectedUserId: (id?: string) => void;
    handleFormSuccess: () => void;
    handleNewUser: () => void;
    triggerRefresh: () => void;
}

const UserContext = createContext<UserContextType | undefined>(undefined);

export const UserProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
    const [showForm, setShowForm] = React.useState(false);
    const [selectedUserId, setSelectedUserId] = React.useState<string | undefined>();
    const [refreshList, setRefreshList] = React.useState(false);

    const handleFormSuccess = () => {
        setShowForm(false);
        setSelectedUserId(undefined);
        setRefreshList(prev => !prev);
    };

    const handleNewUser = () => {
        setShowForm(true);
        setSelectedUserId(undefined);
    };

    const triggerRefresh = () => {
        setRefreshList(prev => !prev);
    };

    const value = {
        showForm,
        selectedUserId,
        refreshList,
        setShowForm,
        setSelectedUserId,
        handleFormSuccess,
        handleNewUser,
        triggerRefresh
    };

    return (
        <UserContext.Provider value={value}>
            {children}
        </UserContext.Provider>
    );
};

export const useUserContext = () => {
    const context = useContext(UserContext);
    if (context === undefined) {
        throw new Error('useUserContext must be used within a UserProvider');
    }
    return context;
}; 