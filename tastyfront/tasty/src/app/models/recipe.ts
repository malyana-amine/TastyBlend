import { Image } from "./image";

export interface Recipe {
    id:any;
    article: string;
    preparationSteps: string;
    ingredients: string;
    images: Image[];
}
