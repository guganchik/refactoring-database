import React, {useEffect, useState} from "react";
import DataTable from "react-data-table-component";

const CasesPage = () => {
    const url = 'http://localhost:35941/computer-cases'

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
            name: "color",
            selector: row => row.color
        },
        {
            name: "formfactor",
            selector: row => row.formfactor
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
                row.manufacturer.toLowerCase().includes(event.target.value.toLowerCase()) ||
                row.color.toLowerCase().includes(event.target.value.toLowerCase()) ||
                row.formfactor.toLowerCase().includes(event.target.value.toLowerCase())
        })
        setRecords(newData)
    }

    return (
        <div>
            <div style={{float: "right"}}>
                <input type="text" placeholder="Поиск..." value={filterText} onChange={handleFilter}/>
                <button onClick={handleClear}>X</button>
            </div>
            <DataTable columns={columns} data={records} fixedHeader pagination defaultSortField="name">
            </DataTable>
        </div>
    );
};

export default CasesPage;