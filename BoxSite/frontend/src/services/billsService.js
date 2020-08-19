import axios from 'axios';

export default{
    async getBills()
    {
        let res = await axios.get('http://localhost:5000/');
        return res;
    },
    async searchBills(choice, query)
    {
        var url = 'http://localhost:5000/query/' + query + '/year/' + choice
        let res = await axios.get(url);
        return res;
    }

}