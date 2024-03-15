import { Image } from "./image";

export interface Recipe {
    article: string;
    preparationSteps: string;
    ingredients: string;
    images: Image[];
}
