import React, {useEffect, useState} from "react";
import DataTable from "react-data-table-component";

const MotherBoardsPage = () => {
    const url = 'http://localhost:35941/mother-boards'

    const [data, setData] = useState('');

    useEffect(() => {
        fetch(url, {
            method: 'GET',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        })
            .then((response) => response.json())
            .then((response) => setData(response))
    }, [])


    const columns = [
        {
            name: "name",
            selector: row => row.name
        },
        {
            name: "manufacturer",
            selector: row => row.manufacturer
        },
        {
            name: "formfactor",
            selector: row => row.formfactor
        },
        {
            name: "ramslots",
            selector: row => row.ramslots
        },
        {
            name: "motherinterface",
            selector: row => row.motherinterface
        },
        {
            name: "socket",
            selector: row => row.socket
        },
        {
            name: "price",
            selector: row => row.price
        }
    ]

    useEffect(() => {
        setRecords(data)
    }, [data]);

    function handleClear() {
        setFilterText("")
        setRecords(data)
    }

    const [records, setRecords] = useState(data)
    const [filterText, setFilterText] = useState("")

    function handleFilter(event) {
        setFilterText(event.target.value)
        const newData = data.filter(row => {
            return row.name.toLowerCase().includes(event.target.value.toLowerCase()) ||
                row.formfactor.toLowerCase().includes(event.target.value.toLowerCase()) ||
                row.ramslots.toLowerCase().includes(event.target.value.toLowerCase()) ||
                row.motherinterface.toLowerCase().includes(event.target.value.toLowerCase()) ||
                row.socket.toLowerCase().includes(event.target.value.toLowerCase())
        })
        setRecords(newData)
    }

    return (
        <div>
            <div style={{float: "right"}}>
                <input type="text" placeholder="Поиск..." value={filterText} onChange={handleFilter}/>
                <button onClick={handleClear}>X</button>
            </div>
            <DataTable columns={columns} data={records} fixedHeader pagination>
            </DataTable>
        </div>
    );
};

export default MotherBoardsPage;