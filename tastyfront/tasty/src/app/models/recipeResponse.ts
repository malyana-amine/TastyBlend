import { User } from "./User";
import { Image } from "./image";

export interface RecipeResponse {
    imageUrl: string;
    article: string;
    preparationSteps: string;
    ingredients: string;
    user: User;
    images: Image[];
}
