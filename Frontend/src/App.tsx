import { UserList } from './components/UserList';
import { UserForm } from './components/UserForm';
import { UserProvider } from './context/UserContext';
import { UserHeader } from './components/UserHeader';

function App() {
    return (
        <UserProvider>
            <div className="container py-4">
                <UserHeader />
                <UserForm />
                <UserList />
            </div>
        </UserProvider>
    );
}

export default App;
