export interface artista {
    id: number;
    nombre: string;
    genero: string;
    descripcion: string;
    urlImagen: string;
    numSeguidores: number;
    disqueraId: number;
    artistasRelacionadosIds: number[];
}