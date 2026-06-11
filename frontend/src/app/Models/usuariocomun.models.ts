import { PlanUsuario } from "./planusuario.models";

export interface usuariocomun{
    id: number;
    nombre: string;
    plan: PlanUsuario;
    usuarioId: number;
    seguidosId: number[];
    playlistsId: number[];
}