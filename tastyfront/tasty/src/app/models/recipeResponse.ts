import { User } from "./User";
import { Image } from "./image";

export interface RecipeResponse {
[x: string]: any;
    imageUrl: string;
    article: string;
    preparationSteps: string;
    ingredients: string;
    user: User;
    images: Image[];
}
