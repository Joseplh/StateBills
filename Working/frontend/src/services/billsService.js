import axios from 'axios';

export default{
    async getBills()
    {
        let res = await axios.get('http://localhost:5000/');
        return res;
    }
}