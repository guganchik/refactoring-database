import React, { useState } from "react";
import axios from "axios";
import "../App.css";
import { useNavigate } from "react-router-dom";

const AuthPage = ({ onAuthenticate }) => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [username, setUsername] = useState("");
    const [isLogin, setIsLogin] = useState(true);
    const [message, setMessage] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        const url = isLogin ? "http://localhost:35941/auth/signin" : "http://localhost:35941/auth/signup";
        try {
            const response = await axios.post(url, { username, email, password });
            localStorage.setItem("token", response.data);
            onAuthenticate();
            navigate("/"); 
        } catch (error) {
            setMessage(error.response.data.message || "Ошибка авторизации");
        }
    };

    return (
        <div className="auth-container">
            <h2>{isLogin ? "Вход" : "Регистрация"}</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    required
                />
                {!isLogin && <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
                }
                <input
                    type="password"
                    placeholder="Пароль"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
                <button type="submit">{isLogin ? "Войти" : "Зарегистрироваться"}</button>
                <p>{message}</p>
                <button type="button" onClick={() => setIsLogin(!isLogin)}>
                    Перейти к {isLogin ? "регистрации" : "входу"}
                </button>
            </form>
        </div>
    );
};

export default AuthPage;