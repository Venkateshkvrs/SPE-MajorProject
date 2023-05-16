import { render, screen, fireEvent } from '@testing-library/react';
import LoginPage from './LoginPage';

describe('LoginPage', () => {
    test('renders login form correctly', () => {
        render(<LoginPage />);

        const usernameInput = screen.getByLabelText('User Id.');
        const passwordInput = screen.getByLabelText('Password');
        const loginButton = screen.getByRole('button', { name: 'Login' });

        expect(usernameInput).toBeInTheDocument();
        expect(passwordInput).toBeInTheDocument();
        expect(loginButton).toBeInTheDocument();
    });

    // test('submits the form with valid credentials', () => {
    //     render(<LoginPage />);
    //
    //     const usernameInput = screen.getByLabelText('Username:');
    //     const passwordInput = screen.getByLabelText('Password:');
    //     const loginButton = screen.getByRole('button', { name: 'Login' });
    //
    //     fireEvent.change(usernameInput, { target: { value: 'admin' } });
    //     fireEvent.change(passwordInput, { target: { value: 'password' } });
    //     fireEvent.click(loginButton);
    //
    //     // Add assertions to check the expected behavior after successful login
    // });
    //
    // test('displays an error message with invalid credentials', () => {
    //     render(<LoginPage />);
    //
    //     const usernameInput = screen.getByLabelText('Username:');
    //     const passwordInput = screen.getByLabelText('Password:');
    //     const loginButton = screen.getByRole('button', { name: 'Login' });
    //
    //     fireEvent.change(usernameInput, { target: { value: 'invalid' } });
    //     fireEvent.change(passwordInput, { target: { value: 'wrongpassword' } });
    //     fireEvent.click(loginButton);
    //
    //     // Add assertions to check the expected behavior for invalid credentials
    // });
});
