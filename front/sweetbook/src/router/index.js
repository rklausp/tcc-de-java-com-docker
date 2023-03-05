import { createBrowserRouter } from "react-router-dom";
import { CreateUserScreen, LoginScreen, PerfilScreen } from "../ui/screens";
import { AlterUserScreen } from "../ui/screens/alter-user/alter-user.screen";
import { FriendslistScreen } from "../ui/screens/friendslist/friendslist.screen";
import { OtherProfileScreen } from "../ui/screens/other-profile/other-profile.sreen";
import { PostScreen } from "../ui/screens/post/post.screen";
import { SolicitationsScreen } from "../ui/screens/solicitations/solicitations.screen";
import { UsersScreen } from "../ui/screens/users/users.screen";
import { PrivateRoute } from "./private-route.component";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <LoginScreen />,
  },
  {
    path: "/cadastro",
    element: <CreateUserScreen />,
  },
  {
    path: "/perfil",
    element: <PrivateRoute Screen={PerfilScreen} />,
  },
  {
    path: "/perfil/post/:id",
    element: <PrivateRoute Screen={PostScreen} />,
  },
  {
    path: "/users",
    element: <PrivateRoute Screen={UsersScreen} />,
  },
  {
    path: `/users/:id`,
    element: <PrivateRoute Screen={OtherProfileScreen} />,
  },
  {
    path: "/user/alter",
    element: <PrivateRoute Screen={AlterUserScreen} />,
  },
  {
    path: "/solicitations",
    element: <PrivateRoute Screen={SolicitationsScreen} />,
  },
  {
    path: "/friends",
    element: <PrivateRoute Screen={FriendslistScreen} />,
  },
]);
