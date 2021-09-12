import axios from "axios";
import { SalePage } from "components/types/sales";
import { formatLocalDate } from "components/utils/format";
import { BASE_URL } from "components/utils/requests";
import { useEffect, useState } from "react";

const DataTable = () => {
  const [page, setPage] = useState<SalePage>({
    first: true,
    last: true,
    number: 0,
    totalElements: 0,
    totalPages: 0,
  });

  useEffect(()=>{
    axios.get(`${BASE_URL}/sales?page=1&size=20&sort=date,desc`).then(response => {
      setPage(response.data)
    })
  },[])

  return (
    <div className="table-responsive">
      <table className="table table-striped table-sm">
        <thead>
          <tr>
            <th>Data</th>
            <th>Vendedor</th>
            <th>Clientes visitados</th>
            <th>Negócios fechados</th>
            <th>Valor</th>
          </tr>
        </thead>
        <tbody>
          {page.content?.map(i => 
          <tr key={i.id}>
            <td>{formatLocalDate(i.date, "dd/MM/yyyy")}</td>
            <td>{i.seller.name}</td>
            <td>{i.visited}</td>
            <td>{i.deals}</td>
            <td>{i.amount.toFixed(2)}</td>
          </tr>
          )}
          
        </tbody>
      </table>
    </div>
  );
};

export default DataTable;
