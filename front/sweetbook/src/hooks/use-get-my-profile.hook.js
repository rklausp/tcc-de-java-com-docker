import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getMyProfile } from "../api/perfil/get-my-profile.api";
import useGlobalUser from "../context/user/user.context";

export function useGetMyProfile() {
  const [profile, setProfile] = useState([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const [, setUser] = useGlobalUser();
  const navigate = useNavigate();

  async function getProfile() {
    try {
      const response = await getMyProfile();
      setProfile(response);
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
    getProfile();
  }, [profile]);

  return { profile, error, loading };
}
