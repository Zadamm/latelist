<template>
    <div>
        <late-times-save-modal></late-times-save-modal>
        <b-table striped hover :items="items"></b-table>
    </div>
</template>

<script>
  import LateTimesSaveModal from './LateTimesSaveModal';

  export default {
    name: 'LateTimes',
    components: {
      LateTimesSaveModal
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

    table >>> tbody tr:first-of-type{
        background-color: red;
        /*animation-name: flash;*/
        animation-duration: 1s;
        animation-iteration-count: infinite;
    }

    table >>> tbody tr:first-of-type:hover{
        animation-name: spin;
        animation-duration: 1s;
        animation-iteration-count: infinite;
    }

</style>