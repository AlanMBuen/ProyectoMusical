import { RolUsuario } from "./rolusuario.models";

export interface usuario{
    id: number;
    username: string;
    password: string;
    rol: RolUsuario;
}