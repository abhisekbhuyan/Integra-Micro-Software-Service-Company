import React from "react";
import { useRoutes } from "react-router-dom";
import routes from "./routes";
function App() {
  const allPages = useRoutes(routes);
  return (
    <>
      {allPages}
    </>
  );
}

export default App;

