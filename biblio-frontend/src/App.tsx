import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Inscription from "./pages/Inscription";


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/inscription" element={<Inscription />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;