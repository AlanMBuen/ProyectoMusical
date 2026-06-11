export interface cancion{
    id: number;
    nombre: string;
    genero: string;
    descripcion: string;
    urlAudio: string;
    duracion: number;
    reproduciones: number;
    artistasId: number[];
    albumId: number;
}