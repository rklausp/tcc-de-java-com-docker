import useGlobalToastr from "../context/toastr/toastr.context";

export function useToastr() {
  const [, setToastr] = useGlobalToastr();

  function showToastr(mensagem) {
    setToastr(mensagem);
  }

  return showToastr;
}
