import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import Tutors from "./pages/Tutors";
import Bookings from "./pages/Bookings";
import Login from "./pages/Login";
import Register from "./pages/Register";
import User from "./pages/User";
import "./App.css";

export default function App() {
    const [count, setCount] = useState(0);

    return (
        <Router>
            <div className="min-h-screen bg-gray-100 text-gray-900">
                {/* Navbar */}
                <header className="bg-blue-600 text-white shadow-md">
                    <nav className="container mx-auto flex justify-between items-center p-4">
                        <h1 className="text-2xl font-bold">TutorConnect</h1>
                        <ul className="flex gap-6">
                            <li><Link to="/" className="hover:underline">Home</Link></li>
                            <li><Link to="/tutors" className="hover:underline">Tutors</Link></li>
                            <li><Link to="/bookings" className="hover:underline">Bookings</Link></li>
                            <li><Link to="/login" className="hover:underline">Login</Link></li>
                            <li><Link to="/register" className="hover:underline">Register</Link></li>
                            <li><Link to="/User" className="hover:underline">User</Link></li>
                        </ul>
                    </nav>
                </header>

                {/* Main Content */}
                <main className="container mx-auto p-6">
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/tutors" element={<Tutors />} />
                        <Route path="/bookings" element={<Bookings />} />
                        <Route path="/login" element={<Login />} />
                        <Route path="/register" element={<Register />} />
                        <Route path="/user" element={<User />} />
                    </Routes>

                    {/* Demo Counter from Vite starter */}
                    <div className="mt-12 text-center">
                        <button
                            onClick={() => setCount((count) => count + 1)}
                            className="bg-purple-600 text-white px-6 py-3 rounded-lg shadow hover:bg-purple-700"
                        >
                            Count is {count}
                        </button>
                        <p className="mt-2 text-sm text-gray-600">
                            This counter is just from the Vite boilerplate.
                        </p>
                    </div>
                </main>

                {/* Footer */}
                <footer className="bg-gray-800 text-white text-center py-4 mt-12">
                    <p>&copy; {new Date().getFullYear()} TutorConnect. All rights reserved.</p>
                </footer>
            </div>
        </Router>
    );
}