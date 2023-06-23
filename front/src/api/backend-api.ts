import axios, {AxiosResponse} from 'axios'

const axiosApi = axios.create({
    baseURL: `/api`,
    timeout: 1000,
    headers: { 'Content-Type': 'application/json' }
});

function encodeQueryData(data) {
    let ret: string[]  = [];
    for (let d in data){
        let param = encodeURIComponent(d) + `=` + encodeURIComponent(data[d]);
        ret.push(param);
    }
    return ret.join('&');
}
export default {
    getLogin(user: string, password: string): Promise<AxiosResponse<string>> {
        return axiosApi.post(`/auth_detail/login`,{
            params: {
                username: user,
                password: password
            }});
    },
    getLogout(): Promise<AxiosResponse<string>> {
        return axiosApi.get(`/auth_detail/logout`);
    },

    getRole(user: string): Promise<AxiosResponse<string>> {
        return axiosApi.get(`/auth_detail/role?loginId=`+user);
    },
    post( action:string, data): Promise<AxiosResponse<string>> {
        return axiosApi.post(
            action,data
        );
    },
    get( action:string, data): Promise<AxiosResponse<string>> {
        if( data == null )
            return axiosApi.get(
                action
            );
        return axiosApi.get(
            action+`?`+encodeQueryData(data)
        );
    }
}