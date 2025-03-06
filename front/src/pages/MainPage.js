import React, {useState, useMemo, useEffect} from "react";
import {Link} from "react-router-dom";
import DataTable from "react-data-table-component";

const MainPage = () => {
    const [price, setPrice] = useState('0');
    const [data, setData] = useState('');
    const url = 'http://localhost:35941/main';

    const handleChange = (event) => {
        if (!isNaN(Number(event.target.value)))
            setPrice(event.target.value);

    };

    useEffect(() => {
        setRecords(data)
    }, [data]);


    const handleClick = (param) => {
        const newPost = {
            "price": param
        }
        setFilterText("")


        fetch(url, {
            method: 'POST',
            body: JSON.stringify(newPost),
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then(res => res.ok ? res : Promise.reject(res))
            .then((response) => response.json())
            .then(response => setData(response))
            .catch(() => console.log('some error'));
    }

    const columns = [
        {
            name: "ComputerCases",
            selector: row => row.computercases
        },
        {
            name: "datastorage",
            selector: row => row.datastorage
        },
        {
            name: "graphicscards",
            selector: row => row.graphicscards
        },
        {
            name: "motherboards",
            selector: row => row.motherboards
        },
        {
            name: "powersupply",
            selector: row => row.powersupply
        },
        {
            name: "processors",
            selector: row => row.processors
        },
        {
            name: "ram_memory",
            selector: row => row.ram_memory
        },
        {
            name: "price",
            selector: row => row.price
        },
        {
            name: "dop",
            cell: row => <Link to="/info" state={{
                computercasesid: row.computercasesid,
                datastorageid: row.datastorageid,
                motherboardsid: row.motherboardsid,
                powersupplyid: row.powersupplyid,
                processorsid: row.processorsid,
                ram_memoryid: row.ram_memoryid,
                graphicscardsid: row.graphicscardsid
            }}>Подробнее</Link>
        }
    ]

    function handleClear() {
        setFilterText("")
        setRecords(data)
    }

    const [records, setRecords] = useState(data)
    const [filterText, setFilterText] = useState("")

    function handleFilter(event) {
        setFilterText(event.target.value)
        if(data!=''){
            const newData = data.filter(row => {
                return row.computercases.toLowerCase().includes(event.target.value.toLowerCase()) ||
                    row.datastorage.toLowerCase().includes(event.target.value.toLowerCase()) ||
                    row.graphicscards.toLowerCase().includes(event.target.value.toLowerCase()) ||
                    row.motherboards.toLowerCase().includes(event.target.value.toLowerCase()) ||
                    row.powersupply.toLowerCase().includes(event.target.value.toLowerCase()) ||
                    row.processors.toLowerCase().includes(event.target.value.toLowerCase()) ||
                    row.ram_memory.toLowerCase().includes(event.target.value.toLowerCase())
            })
            setRecords(newData)
        }
    }

    return (
        <div>
            <div style={{display: "flex", alignItems: "flex-start", justifyContent: "space-between"}}>
                <div>
                    <input
                        type="text"
                        id="price"
                        name="price"
                        onChange={handleChange}
                        value={price}/>
                    <button onClick={() => handleClick(price)}>send</button>
                </div>
                <div>
                    <input type="text" placeholder="Поиск..." value={filterText} onChange={handleFilter}/>
                    <button onClick={handleClear}>X</button>
                </div>
            </div>
            <DataTable columns={columns}
                       data={records}
                       fixedHeader
                       pagination
            />
            {data ? "" :<h1>Укажите сумму, на которую вы хотите собрать компьютер!</h1>}
        </div>
    );

};

export default MainPage;