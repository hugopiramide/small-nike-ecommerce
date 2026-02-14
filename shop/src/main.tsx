import { createBrowserRouter, Navigate, RouterProvider } from 'react-router-dom'
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import "@fontsource/poppins/700.css"
import "@fontsource/poppins/500.css"
import 'bootstrap/dist/css/bootstrap.min.css'
import './index.css'
import Home from './routes/Home.tsx'
import Root from './routes/Root.tsx'
import Articles from './routes/Articles.tsx'
import ArticleDetails from './routes/ArticleDetails.tsx'
import ShopingCart from './routes/ShoppingCart.tsx'
import ErrorPage from './pages/ErrorPage/ErrorPage.tsx'
import PageNotFound from './pages/PageNotFound/PageNotFound.tsx'
import LogIn from './routes/LogIn.tsx'
import Register from './routes/Register.tsx'
import ProtectedRoute from './components/ProtectedRoute';

const router = createBrowserRouter([
  {
    path: '/',
    element: <Root />,
    errorElement: <ErrorPage />,
    children: [
      {
        index: true,
        element: <Navigate to={"/home"} replace />
      },
      {
        path: 'home',
        element: <Home />,
        loader: Home.loader,
      },
      {
        path: 'articles',
        children: [
          {
            index: true,
            element: <Articles />,
            loader: Articles.loader,
          },
          {
            path: ':articleId',
            element: <ArticleDetails />,
            loader: ArticleDetails.loader,
          }
        ]
      },
      // RUTAS PRIVADAS PARA USUARIOS AUTENTICADOS
      {
        element: <ProtectedRoute />,
        children: [
          {
            path: 'cart',
            element: <ShopingCart />,
          },
        ]
      }
    ]
  },
  {
    path: 'register',
    element: <Register />,
  },
  {
    path: 'login',
    element: <LogIn />,
  },
  {
    path: '*',
    element: <PageNotFound />,
  }
])

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)
