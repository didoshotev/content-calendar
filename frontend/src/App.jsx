import { useState } from "react";

function App() {
  const [count, setCount] = useState(0);

  const handleCallAPI = async () => {
    fetch("http://localhost:8080/api/content")
      .then((res) => res.json())
      .then((result) => console.log("content collection: ", result));
  };

  return <button onClick={handleCallAPI}>CALL API</button>;
}

export default App;
