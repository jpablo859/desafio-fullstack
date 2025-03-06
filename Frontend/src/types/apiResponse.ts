export interface ApiResponse<T> {
    statusCode: string;
    isSuccess: boolean;
    transactionDate: string;
    message: string;
    data: T;
}