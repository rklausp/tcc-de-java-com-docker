import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getOtherProfile } from "../api/perfil/get-other-profile.api";
import useGlobalUser from "../context/user/user.context";

export function useGetOtherProfile(id) {
  const [otherProfile, setOtherProfile] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function getUserProfile() {
    try {
      const response = await getOtherProfile(id);
      setOtherProfile(response);
    } catch (error) {
      if (error.response.status === 401) {
        setUser(null);
        localStorage.removeItem("user");
        navigate("/");
      }
      setError(error);
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    getUserProfile();
  }, [otherProfile]);

  return { otherProfile, error, loading };
}
