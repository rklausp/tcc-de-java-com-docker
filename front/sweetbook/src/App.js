import { RouterProvider } from "react-router-dom";
import "./App.css";
import { GlobalToastrProvider } from "./context/toastr/toastr.context";
import { GlobalUserProvider } from "./context/user/user.context";
import { router } from "./router";
import { Toastr } from "./ui/components/toastr/toastr.component";

function App() {
  return (
    <div className="App">
      <GlobalUserProvider>
        <GlobalToastrProvider>
          <RouterProvider router={router} />
          <Toastr />
        </GlobalToastrProvider>
      </GlobalUserProvider>
    </div>
  );
}

export default App;
