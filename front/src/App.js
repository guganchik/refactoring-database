import './App.css';
import React, { useState } from 'react';
import {Routes, Route, Link, Navigate} from 'react-router-dom'
import MainPage from "./pages/MainPage";
import ProcessorsPage from "./pages/ProcessorsPage";
import CasesPage from "./pages/CasesPage";
import DataStoragePage from "./pages/DataStoragePage";
import GraphicCardsPage from "./pages/GraphicCardsPage";
import MotherBoardsPage from "./pages/MotherBoardsPage";
import PowerSupplyPage from "./pages/PowerSupplyPage";
import RamMemoryPage from "./pages/RamMemoryPage";
import InfoPage from "./pages/InfoPage";
import AuthPage from './pages/AuthPage';

function App() {
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    const authenticateUser = () => {
        setIsAuthenticated(true);
    };
    return (
        <>
            <header>
                <Link to="/">Main</Link>
                <Link to="/cases">ComputerCases</Link>
                <Link to="/datastorage">DataStorage</Link>
                <Link to="/graphicscards">GraphicCards</Link>
                <Link to="/motherboards">MotherBoards</Link>
                <Link to="/powersupply">PowerSupply</Link>
                <Link to="/processors">Processors</Link>
                <Link to="/rammemory">RamMemory</Link>
                <Link to="/auth">Authorization</Link>
            </header>
            <Routes>
                <Route path="/auth" element={<AuthPage onAuthenticate={authenticateUser} />} />
                <Route path="/" element={isAuthenticated ? <MainPage /> : <Navigate to="/auth" />}/>
                <Route path="/cases" element={isAuthenticated ? <CasesPage /> : <Navigate to="/auth" />} />
                <Route path="/datastorage" element={isAuthenticated ? <DataStoragePage /> : <Navigate to="/auth" />} />
                <Route path="/graphicscards" element={isAuthenticated ? <GraphicCardsPage /> : <Navigate to="/auth" />} />
                <Route path="/motherboards" element={isAuthenticated ? <MotherBoardsPage /> : <Navigate to="/auth" />} />
                <Route path="/powersupply"  element={isAuthenticated ? <PowerSupplyPage /> : <Navigate to="/auth" />} />
                <Route path="/processors" element={isAuthenticated ? <ProcessorsPage /> : <Navigate to="/auth" />} />
                <Route path="/rammemory" element={isAuthenticated ? <RamMemoryPage /> : <Navigate to="/auth" />} />
                <Route path="/info" element={isAuthenticated ? <InfoPage /> : <Navigate to="/auth" />} />
            </Routes>
        </>
    );
}

export default App;