<template>
  <Line v-if="loaded" :data="chartData" />
</template>

<script>
import { Line } from 'vue-chartjs'
import { Chart as ChartJS,  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend } from 'chart.js'

ChartJS.register( CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend)

export default {
  name: 'LineChart',
  components: { Line },
  data() {
    return {
      loaded: false,
      chartData: {
        labels: [ 'January', 'February', 'March'],
        datasets: [
          {
            label: 'Data One',
            backgroundColor: '#f87979',
            data: [40, 20, 12]
          }
        ]
      }
    }
  },
  async mounted() {
    try {
      const resp  = await fetch("http://localhost:8080/weather-data", { method: "GET", mode: 'cors', headers: { 'Content-Type': 'application/json',}})
      const respData = await resp.json()
      console.info("fetched data is", respData);
      this.chartData.labels = respData.times.map(time => new Date(time).toLocaleString());
      this.chartData.datasets[0].data = respData.temperatures;
      this.loaded = true;
    } catch (error) {
      console.error(error)
    }
  }
}
</script>
