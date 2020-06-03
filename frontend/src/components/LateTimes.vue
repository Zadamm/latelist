<template>
    <div class="late-table">
        <b-button @click="modalShow = !modalShow">Open Modal</b-button>
        <b-modal v-model="modalShow">Hello From Modal!</b-modal>
        <b-table striped hover :items="items"></b-table>
    </div>
</template>

<script>
  export default {
    name: 'LateTimes',
    data() {
      return {
        modalShow: false
      }
    },
    computed: {
      items: function () {
        return this.$store.getters.getAggregateLateTimes;
      }
    }
  }
</script>

<style scoped>

    @keyframes flash {
        0%   {background-color: red;}
        25%  {background-color: yellow;}
        50%  {background-color: blue;}
        100% {background-color: green;}
    }

    @keyframes spin {
        from {
            transform:rotate(0deg);
        }
        to {
            transform:rotate(360deg);
        }
    }

    .late-table table >>> tbody tr:first-of-type{
        background-color: red;
        animation-name: flash;
        animation-duration: 1s;
        animation-iteration-count: infinite;
    }

    .late-table table >>> tbody tr:first-of-type:hover{
        animation-name: spin;
        animation-duration: 1s;
        animation-iteration-count: infinite;
    }

</style>