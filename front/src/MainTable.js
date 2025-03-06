import {useState} from "react";

const MainTable = () => {
    // const newPost = {
    //     price: 50000
    // }
    //
    // fetch('http://localhost:8080/main', {
    //     method: 'POST', // Здесь так же могут быть GET, PUT, DELETE
    //     body: JSON.stringify(newPost), // Тело запроса в JSON-формате
    //     headers: {
    //         // Добавляем необходимые заголовки
    //         'Content-type': 'application/json; charset=UTF-8',
    //     },
    // })
    //     .then((response) => response.json())
    //     .then((data) => {
    //         console.log(data)
    //         // {title: "foo", body: "bar", userId: 1, id: 101}
    //     })
    //     // .then(res => console.log(res))
    //
    // // useEffect(() => {
    // //     axios.post('http://localhost:8080/main'), {
    // //         // body: JSON.stringify(newPost)
    // //         price: 40000
    // //     }
    // //         .then((res)=>{
    // //             console.log(res)
    // //         })
    // //         // .then(res => res.json())
    // //         // .then(
    // //         //     res => setData(res)
    // //         // )
    // // }, [])
    // // const handleLike = (params) => {
    // //     axios.post('http://localhost:8080/main'), {
    // //         price: params
    // //     }
    // //         .then((res) => {
    // //             console.log(res)
    // //         })
    // // }
    //
    // // fetch('http://localhost:8080/main', {
    // //     method: 'POST',
    // //     body: JSON.stringify(newPost) // Тело запроса в JSON-формате
    // // })
    // //
    // //     .then((response) => response.json())
    // //     .then((data) => {
    // //         console.log(data)
    // //         // {title: "foo", body: "bar", userId: 1, id: 101}
    // //     })
    //
    //
    // // const columns = [
    // //     {
    // //         name: "ComputerCases",
    // //         selector: row => row.ComputerCases
    // //     },
    // //     {
    // //         name: "datastorage",
    // //         selector: row => row.datastorage
    // //     },
    // //     {
    // //         name: "motherboards",
    // //         selector: row => row.motherboards
    // //     },
    // //     {
    // //         name: "powersupply",
    // //         selector: row => row.powersupply
    // //     },
    // //     {
    // //         name: "processors",
    // //         selector: row => row.processors
    // //     },
    // //     {
    // //         name: "price",
    // //         selector: row => row.price
    // //     }
    // // ]
    // // const data = [
    // //     {
    // //         id: 1,
    // //         ComputerCases: "yea",
    // //         datastorage: "d",
    // //         motherboards: "b",
    // //         powersupply: "a",
    // //         processors: "he",
    // //         price: "10"
    // //     }
    // // ]
    const [price, setPrice] = useState(null);

    const handleLike = (params) => {


        const newPost = {
            "price": 60000
        }

        fetch('http://localhost:35941/main', {
                method: 'POST',
                body: JSON.stringify(newPost),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                },
            })
                .then((response) => response.json())
                .then((data) => {
                    console.log(data)
                })
    }
    return (

        <div>
            <input
                type="text"
                id="price"
                name="price"
                value={price}
            />
            <button onClick={() => handleLike(50000)}>send</button>
        </div>
    );
};

export default MainTable;