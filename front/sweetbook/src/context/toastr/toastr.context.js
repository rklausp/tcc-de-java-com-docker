import createGlobalState from "react-create-global-state";

const ininitialState = "";

const [useGlobalToastr, Provider] = createGlobalState(ininitialState);

export const GlobalToastrProvider = Provider;

export default useGlobalToastr;
