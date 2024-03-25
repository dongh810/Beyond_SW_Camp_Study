<!-- vbase-3 setup -->
<template>
    <div>
        <h1>MyComponenet</h1>
    </div>
</template>

<script>
    import {onMounted} from 'vue';

    export default {
        setup() {
            onMounted(async() => {
                console.log("Helloo Vue!");
            })
        }
    }
    
</script>

<style scoped>

</style>