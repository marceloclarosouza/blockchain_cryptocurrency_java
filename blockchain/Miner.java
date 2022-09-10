package blockchain;

public class Miner {
    private double reward;

    public void mine(Block block, BlockChain blockchain) {

        while(!isGoldenhash(block)) {
            block.incrementNonce();
            block.generateHash();
        }

        System.out.println(block + " has just mined...");
        System.out.println("Hash is: " + block.getHash());

        blockchain.addBlock(block);
        reward += Constants.REWARD;
    }

    private boolean isGoldenhash(Block block) {
        String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
        return block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeros);
    }

    public double getReward(){
        return this.reward;
    }
}
