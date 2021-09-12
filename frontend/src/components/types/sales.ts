import { Seller } from './seller';
export type Sale = {
    visited: number;
    deals: number;
    amount: number;
    date: string;
    seller: Seller
    id: number;
}

export type SalePage = {
    content?: Sale[];
    last: boolean;
    totalPages: number;
    totalElements: number;
    first: boolean;
    numberOfElements?: number;
    size?: number;
    number: number;    
    empty?: boolean;
}

export type SaleSum =  {
    sellerName: string;
    sum: number;
}

export type SaleSuccess = {
    sellerName: string;
    visited: number;
    deals: number;
}