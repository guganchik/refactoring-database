import React, {useEffect, useState} from 'react';

import {Redirect, useLocation, useParams} from 'react-router-dom';
import compcase from '../img/case.png';
import card from '../img/card.png';
import block from '../img/block.png';
import cpu from '../img/cpu.png';
import disk from '../img/disk.png';
import mother from '../img/mother.png';
import ram from '../img/ram.png';


const InfoPage = () => {
    console.log(useLocation())
    const location = useLocation();
    const state = location.state;
    const url = 'http://localhost:35941/assembly'
    const [data, setData] = useState('');

    useEffect(() => {
        fetch(url, {
            method: 'POST',
            body: JSON.stringify(state),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            // .then((response) => console.log(response))
            .then((response) => setData(response))
    }, [])

    return (
        data ?
        <table className="table">
            <tbody>
            <tr>
                <td>
                    <p className="leftColumn">case</p>
                    <img src={compcase} alt="case"/>
                </td>
                <td>
                    <p> name: {data.computerCases.name}</p>
                    <p> manufacturer: {data.computerCases.manufacturer}</p>
                    <p> color: {data.computerCases.color}</p>
                    <p> formfactor: {data.computerCases.formfactor}</p>
                    <p> price: {data.computerCases.price}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p className="leftColumn">datastorage</p>
                    <img src={disk} alt="datastorage"/>
                </td>
                <td>
                    <p> name: {data.dataStorage.name}</p>
                    <p> manufacturer: {data.dataStorage.manufacturer}</p>
                    <p> capacity: {data.dataStorage.capacity}</p>
                    <p> type: {data.dataStorage.type}</p>
                    <p> price: {data.dataStorage.price}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p className="leftColumn">graphicscard</p>
                    <img src={card} alt="graphicscard"/>
                </td>
                <td>
                    <p> name: {data.graphicsCards.name}</p>
                    <p> manufacturer: {data.graphicsCards.manufacturer}</p>
                    <p> powerconsumption: {data.graphicsCards.powerconsumption}</p>
                    <p> graphinterface: {data.graphicsCards.graphinterface}</p>
                    <p> vram: {data.graphicsCards.vram}</p>
                    <p> price: {data.graphicsCards.price}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p className="leftColumn">motherboard</p>
                    <img src={mother} alt="motherboard"/>
                </td>
                <td>
                    <p> formfactor: {data.motherBoards.formfactor}</p>
                    <p> manufacturer: {data.motherBoards.manufacturer}</p>
                    <p> motherinterface: {data.motherBoards.motherinterface}</p>
                    <p> name: {data.motherBoards.name}</p>
                    <p> price: {data.motherBoards.price}</p>
                    <p> ramslots: {data.motherBoards.ramslots}</p>
                    <p> socket: {data.motherBoards.socket}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p className="leftColumn">powersupply</p>
                    <img src={block} alt="powersupply"/>
                </td>
                <td>
                    <p> manufacturer: {data.powerSupply.manufacturer}</p>
                    <p> modular: {data.powerSupply.modular}</p>
                    <p> name: {data.powerSupply.name}</p>
                    <p> power: {data.powerSupply.power}</p>
                    <p> price: {data.powerSupply.price}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p className="leftColumn">processor</p>
                    <img src={cpu} alt="processor"/>
                </td>
                <td>
                    <p> clockspeed: {data.processors.clockspeed}</p>
                    <p> cores: {data.processors.cores}</p>
                    <p> manufacturer: {data.processors.manufacturer}</p>
                    <p> name: {data.processors.name}</p>
                    <p> price: {data.processors.price}</p>
                    <p> socket: {data.processors.socket}</p>
                </td>
            </tr>
            <tr>
                <td>
                    <p className="leftColumn">ram_memory</p>
                    <img src={ram} alt="ram_memory"/>
                </td>
                <td>
                    <p> capacity: {data.ramMemory.capacity}</p>
                    <p> frequency: {data.ramMemory.frequency}</p>
                    <p> name: {data.ramMemory.name}</p>
                    <p> price: {data.ramMemory.price}</p>
                    <p> ramtype: {data.ramMemory.ramtype}</p>
                </td>
            </tr>
            </tbody>
        </table> : ""
    );
};

export default InfoPage;