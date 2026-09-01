import React, { Children, lazy, Suspense } from "react";
import { Navigate } from "react-router-dom";
import Authentication from "./component/authentication/authentication";
import Layout from "./component/layout/layout"

const Loadable = (Component) => (props) =>
  (
    <Suspense fallback={<>Loading...</>}>
      <Component {...props} />
    </Suspense>
  );



const Login = Loadable(lazy(() => import("./pages/login/login")));

const HR = Loadable(lazy(() => import("./pages/hrpage/hr")));

const Support = Loadable(lazy(() => import("./pages/support/support")));

const Finance = Loadable(lazy(() => import("./pages/finance/financeScreen")));

const PortalNotFound = Loadable(
  lazy(() => import("./pages/login/portalNotFound"))
);

const RoleNotFound = Loadable(
  lazy(() => import("./pages/login/roleNotFound"))
);

const Error = Loadable(lazy(() => import("./component/pageError/404")));

const routes = [
  {
    path: "login",
    element: (<Login />),
  },
  {
    path: "hr",
    element: (
      <Authentication>
        <Layout />
      </Authentication>
    ),
    children:[
      {
        path:"",
        element:<HR/>
      }
    ]
  },
  {
    path: "support",
    element: (
      <Authentication>
        <Layout />
      </Authentication>
    ),
    children:[
      {
        path:"",
        element:<Support/>
      }
    ]
  },
  {
    path: "finance",
    element: (
      <Authentication>
        <Layout />
      </Authentication>
    ),
    children:[
      {
        path:"",
        element:<Finance/>
      }
    ]
  },
  {
    path: "notfound",
    element: <PortalNotFound />,
  },
  
  {
    path: "roleNotfound",
    element: (
      <Authentication>
        <Layout />
      </Authentication>
    ),
    children:[
      {
        path:"",
        element:<RoleNotFound/>
      }
    ]
  },


  {
    path: "/",
    element: <Navigate to="/login" />,
  },
  {
    path: "*",
    element: <Error />,
  },
];
export default routes;
