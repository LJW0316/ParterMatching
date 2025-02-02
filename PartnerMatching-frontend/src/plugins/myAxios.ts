import axios, {AxiosInstance} from "axios";

const NODE_ENV = process.env.NODE_ENV

const myAxios : AxiosInstance = axios.create({

    // baseURL: NODE_ENV === 'production' ? 'http://47.103.85.74:8080/api' : 'http://localhost:8080/api'
    baseURL: 'http://47.103.85.74:8080/api',
});

//携带Cookie
myAxios.defaults.withCredentials = true;

// 添加请求拦截器
myAxios.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    console.log("发送请求", config);
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

// 添加响应拦截器
myAxios.interceptors.response.use(function (response) {
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    console.log("收到响应", response);
    //未登录,跳转到登录页
    if (response?.data?.code === 40100) {
        const  redirectUrl = window.location.href;
        window.location.href = `/user/login?redirect=${redirectUrl}`;
    }
    return response.data;
}, function (error) {
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    return Promise.reject(error);
});

export default myAxios;