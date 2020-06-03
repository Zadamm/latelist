<template>
    <div>
        <b-button v-b-modal.late-times-save-modal>New late record</b-button>
        <b-modal id="late-times-save-modal"
                 ref="modal"
                 title="Record a late time"
                 @show="resetModal"
                 @hidden="resetModal"
                 @ok="handleOk">
            <form ref="form" @submit.stop.prevent="handleSubmit">
                <b-form-group
                        :state="nameState"
                        label="Name"
                        label-for="name-input"
                        invalid-feedback="Name is required"
                >
                    <b-form-input
                            id="name-input"
                            v-model="lateTime.name"
                            :state="nameState"
                            required
                    ></b-form-input>
                </b-form-group>
                <b-form-group
                        :state="durationState"
                        label="Duration"
                        label-for="duration-input"
                        invalid-feedback="Has to be greater than 0"
                >
                    <b-form-input
                            id="duration-input"
                            v-model="lateTime.duration"
                            :state="durationState"
                            :type="'number'"
                            min="1"
                    ></b-form-input>
                </b-form-group>
                <b-form-group
                        :state="dateState"
                        label="Date"
                        label-for="date-input"
                        invalid-feedback="Date is required"
                >
                    <b-form-datepicker
                            id="date-input"
                            name="date-input"
                            v-model="lateTime.date"
                            :state="dateState"
                            required
                    ></b-form-datepicker>
                </b-form-group>
            </form>
        </b-modal>
    </div>
</template>

<script>
  export default {
    name: 'LateTimesSaveModal',
    data() {
      return {
        modalShow: false,
        lateTime: {
          name: '',
          duration: 0,
          date: null
        },
        nameState: null,
        durationState: null,
        dateState: null
      }
    },
    methods: {
      checkFormValidity() {
        this.$refs.form.forEach(form => {
          if (form.id === 'name-input') this.nameState = form.checkValidity();
          if (form.id === 'duration-input') this.durationState = form.checkValidity();
          if (form.id === 'date-input') this.dateState = this.lateTime.date !== null;
        })
        return this.nameState && this.durationState && this.dateState;
      },
      resetModal() {
        this.lateTime = {
          name: '',
          duration: 0,
          date: null
        }
        this.nameState = null;
        this.durationState = null;
        this.dateState = null;
      },
      handleOk(bvModalEvt) {
        bvModalEvt.preventDefault()
        this.handleSubmit()
      },
      handleSubmit() {
        if (!this.checkFormValidity()) {
          return
        }
        this.$store.dispatch('saveLateTimes', this.lateTime)
          .then(() => {
            this.$nextTick(() => {
              this.$bvModal.hide('late-times-save-modal');
            })
          })
          .catch((error) => {
            this.$nextTick(() => {
              this.$bvModal.hide('late-times-save-modal');
            })
            console.log(error);
          });
      }
    }
  }
</script>

<style scoped>

</style>