<template>
    <div class="small" v-if="datacollection">
        <bar-chart :chart-data="datacollection"></bar-chart>
    </div>
</template>

<script>
  import moment from 'moment'
  import BarChart from './BarChart.js'
  import api from './backend-api'

  export default {
    components: {
      BarChart
    },
    data () {
      return {
        datacollection: null
      }
    },
    mounted () {
      api.getLateTimesStatistics()
        .then(response => this.fillData(response.data))
    },
    methods: {
      fillData (data) {
        this.datacollection = {
          labels: data.map(entry => {
            const date = moment(entry.date);
            console.log(date)
            return date.format('MM/DD')
          }),
          datasets: [
            {
              label: 'Napi összes késés',
              backgroundColor: '#eb0bc3',
              data: data.map(entry => {return entry.durationSum})
            }
          ]
        }
      }
    }
  }
</script>

<style>
    .small {
        max-width: 600px;
        margin:  150px auto;
    }
</style>