import './App.css';
import {Routes, Route, Link} from 'react-router-dom'
import MainPage from "./pages/MainPage";
import ProcessorsPage from "./pages/ProcessorsPage";
import CasesPage from "./pages/CasesPage";
import DataStoragePage from "./pages/DataStoragePage";
import GraphicCardsPage from "./pages/GraphicCardsPage";
import MotherBoardsPage from "./pages/MotherBoardsPage";
import PowerSupplyPage from "./pages/PowerSupplyPage";
import RamMemoryPage from "./pages/RamMemoryPage";
import InfoPage from "./pages/InfoPage";

function App() {
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

            </header>
            <Routes>
                <Route path="/" element={<MainPage />}/>
                <Route path="/cases" element={<CasesPage />}/>
                <Route path="/datastorage" element={<DataStoragePage />}/>
                <Route path="/graphicscards" element={<GraphicCardsPage />}/>
                <Route path="/motherboards" element={<MotherBoardsPage />}/>
                <Route path="/powersupply" element={<PowerSupplyPage />}/>
                <Route path="/processors" element={<ProcessorsPage />}/>
                <Route path="/rammemory" element={<RamMemoryPage />}/>
                <Route path="/info" element={<InfoPage />}/>
            </Routes>
        </>
    );
}

export default App;